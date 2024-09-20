<template>
  <form action="" @submit.prevent="submitForm">
    <div>
      <label for="userId">ID : </label>
      <input id="userId" type="text" v-model="username">
    </div>
    <div>
      <label for="password">PW : </label>
      <input id="password" type="text" v-model="password">
    </div>
    <button type="submit">로그인</button>
  </form>
</template>

<script>
  import axios from 'axios';
  import { ref } from 'vue';

  export default {
    // Composition API 코드
    setup() {
      // data
      let username = ref('');
      let password = ref('');

      // methods
      let submitForm = () => {
        axios.post('https://jsonplaceholder.typicode.com/users/', {
          username: username.value,
          password: password.value
        }).then(response => {
          console.log(response);
        })
      }
        return { username, password, submitForm }
    },


    // data() {
    //   return {
    //     username: '',
    //     password: '',
    //   }
    // }, 
    // methods: {
    //   submitForm() {
    //     const data = {
    //       // post 값에 넘길 데이터
    //       username: this.username,
    //       password: this.password, 
    //     }

    //     axios.post('https://jsonplaceholder.typicode.com/users/', data)
    //       .then(response => {
    //         console.log(response)
    //       });
    //   }
    // }
  }
</script>

<style scoped>

</style>