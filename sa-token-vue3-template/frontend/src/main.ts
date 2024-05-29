// @ts-nocheck
import '@/styles/style.scss'
import '@/styles/common.scss'
import { createApp } from 'vue'
import App from '@/App.vue'
// 引入andv icon
import * as Icons from '@ant-design/icons-vue'
import Icon from '@/components/Icon/Icon.vue'
import pinia from '@/stores'
import router from '@/router'
// axios拦截器
import '@/plugins/axios'
// 国际化
import i18n from '@/locales'
// 过渡动画
import VueTransitions from '@morev/vue-transitions'
import '@morev/vue-transitions/styles'
// monaco editor
import { install as VueMonacoEditorPlugin } from '@guolao/vue-monaco-editor'

const app = createApp(App)
app.use(pinia)
app.use(router)
app.use(i18n)
app.use(VueTransitions)
app.use(VueMonacoEditorPlugin, {
  paths: {
    vs: 'https://cdn.staticfile.net/monaco-editor/0.45.0/min/vs',
  },
})
app.component(Icon)
// 注册全局图标
Object.keys(Icons).forEach((key) => {
  app.component(key, Icons[key])
})

app.mount('#app')
