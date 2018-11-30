/* Auteur : Christophe Sulyven  */

// Inclusion de la librairie :
#include "DHT.h"

// Définition des PIN de branchement :
#define PIN_PELTIER 3
#define PIN_VENTILO 5
#define PIN_DHT 2

// Définition des constantes :
#define A 17.25f
#define B 237.7f
#define STEP 5    // Pas de régulation du capteur

// On initialise le capteur DHT (DHT-22) :
DHT dht(PIN_DHT, DHT22);

// Déclaration des variables :
float power;        // Puissance envoyée au module Peltier
float humidite;     // Humidité relative mesurée
float temperature;  // Température mesurée
float pointDeRosee; // Température de rosée
float consigne;     // Température de consigne
