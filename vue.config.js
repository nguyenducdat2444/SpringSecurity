const { defineConfig } = require('@vue/cli-service');
module.exports = defineConfig({
  devServer: {
    port: 8080, // Chạy FE tại cổng 8080
    proxy: {
      '/api': {
        target: 'http://localhost:9090', // BE tại cổng 9090
        changeOrigin: true,
        pathRewrite: { '^/api': '' }
      }
    }
  }
});
