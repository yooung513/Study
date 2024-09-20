<template>
  <AppHeader 
    :appTitle="message"
    @change="changeMessage">
  </AppHeader>
</template>

<script>
  // import 컴포넌트 이름 from './컴포넌트 경로'
  import AppHeader from './components/AppHeader.vue';

  export default {
    components: {
      // '컴포넌트 이름': 컴포넌트 내용
      // 'AppHeader': AppHeader // 앞 뒤가 동일하면 줄일 수 있다.
      AppHeader
    },
    data() {
      return {
        message: '앱 헤더 컴포넌트'
      }
    },
    methods: {
      changeMessage() {
        this.message = '변경된 헤더 컴포넌트'
      }
    },
  }
</script>

<style scoped>

</style>