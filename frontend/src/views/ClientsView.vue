<script setup>
import { onMounted, ref } from "vue"
import { getClients, createClient } from "../api/clientService"

const clients = ref([])
const loading = ref(true)
const error = ref(null)

// Form state
const name = ref("")
const email = ref("")

const loadClients = async () => {
  try {
    const response = await getClients()
    clients.value = response.data
  } catch (err) {
    error.value = "Erreur lors du chargement"
  } finally {
    loading.value = false
  }
}

const submitForm = async () => {
  try {
    const newClient = {
      name: name.value,
      email: email.value
    }

    await createClient(newClient) // Envoie la création du client

    // reset form
    name.value = ""
    email.value = ""

    // reload la liste des clients
    await loadClients()

  } catch (err) {
    error.value = "Erreur lors de la création"
  }
}

onMounted(loadClients)

</script>

<template>
  <div class="container mt-4">

    <h1>Clients</h1>

    <!-- Loading -->
    <div v-if="loading" class="alert alert-info">
      Chargement...
    </div>

    <!-- Error -->
    <div v-if="error" class="alert alert-danger">
      {{ error }}
    </div>

    <form @submit.prevent="submitForm" class="card p-3 mt-3">
      <h5>Ajouter un client</h5>
      <div class="mb-2">
        <input v-model="name" class="form-control" placeholder="Nom" required />
      </div>
      <div class="mb-2">
        <input v-model="email" type="email" class="form-control" placeholder="Email" required />
      </div>
      <button class="btn btn-primary">Créer</button>
    </form>

    <!-- Table -->
    <table v-if="!loading && !error" class="table table-striped mt-3">
      <thead>
        <tr>
          <th>ID</th>
          <th>Nom</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="client in clients" :key="client.id">
          <td>{{ client.id }}</td>
          <td>{{ client.name }}</td>
          <td>{{ client.email }}</td>
        </tr>
      </tbody>
    </table>

  </div>
</template>