# ISS_2025
Repository del corso Ingegneria dei Sistemi Software a.a. 2024/2025 - Guiducci Daniele

<h2 id="Fase1">Fase 1</h2>  

### Dagli oggetti ai microservizi (in Java)
* [conwayLife_Java](conwayLife_Java): Parte core del gioco, da JavaScript a Java, applicazione del refactoring per introdurre classi esplicite per Cell e Grid, seguendo uno sviluppo incrementale e agile.
* [conwaygui_myVersion](conwaygui_myVersion): GUI in HTML che comunica con il server tramite WebSocket, utilizzando Spring Boot per integrare la nuova interfaccia senza modificare la logica del gioco. (Ingloba [conwayLife_Java](conwayLife_Java))
* [commdemo](commdemo): microservizio indipendente con esempi di interazione via WS e via MQTT.
* [conway25JavaMqtt](conway25JavaMqtt): GameLife standalone , implementa la logica del gioco e comunica gli aggiornamenti tramite MQTT
* [conwayguialone](conwayguialone): GUI separata che usa Paho per ricevere e inviare messaggi MQTT senza dipendere dal servizio applicativo , comunica con [conway25JavaMqtt](conway25JavaMqtt)
