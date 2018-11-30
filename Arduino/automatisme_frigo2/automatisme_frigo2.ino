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
  consigne = 15.0d;
  pointDeRosee = -273.15d;

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
      reduire();
    else if (temperature > consigne)
      augmenter();
    else
      maintenir();
      
    if (Serial.available() > 0)
    {
      i = 0;
      
      while (Serial.available() > 0)
      {
        buf[i] = Serial.read();
      }
      
      consigne = (double)(*reinterpret_cast<int*>(buf));
    }

    Serial.print(temperature);
    Serial.print(';');
    Serial.print(humidite);
    Serial.print(';');
    Serial.print(pointDeRosee);
    Serial.print(';');
    Serial.println(false);
    
  } while (temperature > pointDeRosee);

  do {
    reduire();

    Serial.print(temperature);
    Serial.print(';');
    Serial.print(humidite);
    Serial.print(';');
    Serial.print(pointDeRosee);
    Serial.print(';');
    Serial.println(true);
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

