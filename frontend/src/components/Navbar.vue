<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <router-link class="navbar-brand" to="/">Vitrine</router-link>
  
        <div>
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
  
            <li class="nav-item">
              <router-link class="nav-link" to="/">Accueil</router-link>
            </li>
  
            <li class="nav-item">
              <router-link class="nav-link" to="/clients">Clients</router-link>
            </li>
  
            <li class="nav-item">
              <router-link class="nav-link" to="/orders">Commandes</router-link>
            </li>
  
          </ul>
        </div>
      </div>
    </nav>
</template>