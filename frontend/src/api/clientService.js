import api from "./api"

export const getClients = () => {
  return api.get("/clients")
}

export const createClient = (client) => {
  return api.post("/clients", client)
}