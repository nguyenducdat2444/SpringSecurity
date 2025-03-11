const { defineConfig } = require('@vue/cli-service')
module.exports = {
  devServer: {
    proxy: {
      '/api/auth': {
        target: 'http://localhost:9090',
        changeOrigin: true
      }
    }
  }
};
