<template>
  <Editor :value="value" :plugins="plugins" @change="handleChange" />
</template>

<script setup lang="ts">
import math from '@bytemd/plugin-math'
import gfm from '@bytemd/plugin-gfm'
import highlight from '@bytemd/plugin-highlight'
import mediumZoom from '@bytemd/plugin-medium-zoom'
import mermaid from '@bytemd/plugin-mermaid'
import theme from '../plugin-theme/index'
// @ts-ignore
import { Editor } from '@bytemd/vue-next'

const plugins = [
  math(),
  gfm(),
  highlight(),
  mediumZoom(),
  mermaid(),
  theme({
    theme: 'github', // 默认掘金主题
    highlight: 'github', // 默认代码高亮样式
  }),
]
const emit = defineEmits(['update:value'])
defineProps<{ value: string }>()

function handleChange(v: string) {
  emit('update:value', v)
}

</script>

<style lang="scss">
.bytemd-toolbar-icon.bytemd-tippy.bytemd-tippy-right:last-child {
  display: none;
}
</style>
