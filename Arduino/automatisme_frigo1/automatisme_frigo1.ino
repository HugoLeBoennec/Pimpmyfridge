/* Auteur : Christophe Sulyven  */

// Inclusion des en-têtes :
#include "automatisme1.h"

// Fonction d'initialisation :
void setup()
{
  // On initialise les PIN :
  Serial.begin(9600);
  pinMode(PIN_VENTILO, OUTPUT);

  // On initialise les variables globales :
  power = 50;
  pointDeRosee = -273.15f;  // Température basse pour pas de problèmes au départ
  consigne = 18.0f;

  // On démarre le capteur DHT :
  dht.begin();
}

// Fonction de boucle :
void loop()
{
  // Variables locales :
  float alpha;  // Alpha pour le calcul du point de rosée
  
  // Si la température n'excède pas le dessous du point de rosée :
  if (temperature > pointDeRosee)
  {
    // On lit l'humidité et la température :
    humidite = dht.readHumidity() / 100.0f;
    temperature = dht.readTemperature();

    // On vérifie les erreurs éventuelles :
    if (isnan(humidite) || isnan(temperature))
    {
      Serial.println("Echec de lecture du capteur DHT !");
      return;
    }

    // On calcule la nouvelle température de rosée :
    alpha = ((A * temperature) / (B + temperature)) * log(humidite);
    pointDeRosee = (B * alpha) / (A - alpha);

    // On régule la température :
    if (temperature < consigne)
      power += STEP;
    else if (temperature > consigne)
      power -= STEP;

    // Limitation de la puissance (0 <= power <= 99) :
    power = min(max(power, 0), 99);

    // Ecriture sur le PIN :
    analogWrite(PIN_PELTIER, map(power, 0, 99, 0, 255));

    // On communique via le port série :
    Serial.println(humidite);
    Serial.println(temperature);
  }
}

