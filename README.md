# Site de commandes

## Lancement des Conteneurs Docker

Pour démarrer les conteneurs Docker en mode détaché :

```sh
docker-compose up -d
```

## Arrêt des Conteneurs Docker

Pour arrêter les conteneurs :

```sh
docker-compose down
```

Pour arrêter les conteneurs et supprimer les volumes associés :

```sh
docker-compose down -v
```

## Lancement du backend

Pour lancer le backend :

```sh
cd backend
mvn clean install
cd target
java -jar app.jar OU java -jar .\demo-1.0-SNAPSHOT.jar
```

## Accès à la Base de Données (DB)

Pour entrer dans le conteneur PostgreSQL et accéder à la base de données :

```sh
docker exec -it vitrine-postgres psql -U postgres -d vitrine-db
```
