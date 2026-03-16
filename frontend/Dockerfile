FROM node:20-alpine

WORKDIR /app

# copier les dépendances
COPY package*.json ./

RUN npm install

# copier le reste du projet
COPY . .

EXPOSE 5173

CMD ["npm", "run", "dev", "--", "--host"]