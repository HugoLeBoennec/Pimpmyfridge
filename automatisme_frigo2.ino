/*Auteur : CHRISTOPHE Sulyven*/

// Inclusion des en-têtes :
#include "automatisme1.h"

//Fonction d'initialisation :
void setup()
{
  //On initialise les PIN :
  Serial.begin (9600);

  //on initialise les variables globales :
  power = 0;
  pointDeRosee = -273.15f;

  //On démarre le capteur DHT :
  dht.begin();
}

void loop() {
  do {
    humidite = dht.readHumidity() / 100.0f;
    temperature = dht.readTemperature();

    if (isnan(humidite) || isnan(temperature)) {
      Serial.println("Echec de lecture du cpteur DHT !");
      return;
    }

    alpha = ((A * temperature) / (B + temperature) + log(humidite));
    pointDeRosee = ((B * alpha) / (A - alpha));

    if (temperature < consigne)
      augmenter();
    else if (temperature > consigne)
      reduire();
    else
      maintenir();

  } while (temperature > pointDeRosee);

  do {
    reduire();
  } while (temperature < pointDeRosee);
}


void augmenter() {
  power = 99;
  peltier_level = map(power, 0, 99, 0, 255);
  analogWrite(pinPeltier, peltier_level);
}

void reduire() {
  power = 0;
  peltier_level = map(power, 0, 99, 0, 255);
  analogWrite(pinPeltier, peltier_level);
}

void maintenir() {
  power = 49;
  peltier_level = map(power, 0, 99, 0, 255);
  analogWrite(pinPeltier, peltier_level);
}

