<template>
  <Viewer :value="value" :plugins="plugins" />
</template>

<script setup lang="ts">
import math from '@bytemd/plugin-math'
import gfm from '@bytemd/plugin-gfm'
import highlight from '@bytemd/plugin-highlight'
import mediumZoom from '@bytemd/plugin-medium-zoom'
import mermaid from '@bytemd/plugin-mermaid'
import theme from '../plugin-theme/index'
// @ts-ignore
import { Viewer } from '@bytemd/vue-next'

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
defineProps<{ value: string }>()

</script>

<style>
code {
  font-family: SFMono-Regular, Consolas, Liberation Mono, Menlo, monospace;
}
</style>
