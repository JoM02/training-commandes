<script setup>
import { onMounted, ref } from "vue"
import { getClients } from "../api/clientService"

const clients = ref([])
const loading = ref(true)
const error = ref(null)

onMounted(async () => {
  try {
    const response = await getClients()
    clients.value = response.data
  } catch (err) {
    error.value = "Erreur lors du chargement des clients"
  } finally {
    loading.value = false
  }
})
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