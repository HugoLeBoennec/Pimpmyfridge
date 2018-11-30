/*Auteur : CHRISTOPHE Sulyven*/

#include "DHT.h"
#define pinPeltier 3
#define pinVentilo 5
#define A 17.25f
#define B 237.7f
#define pinDHT 2
#define typeDHT DHT22
DHT dht (pinDHT, typeDHT);
void augmenter();
void maintenir();
void reduire();
float humidite, temperature, pointDeRosee, consigne, alpha;
int power = 0;
int peltier_level = map(power, 0, 99, 0, 255);

