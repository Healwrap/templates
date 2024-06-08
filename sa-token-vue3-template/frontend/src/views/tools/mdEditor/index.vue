<script setup lang="ts">
import { ref } from 'vue'
import IMdEditor from '@/components/bytemd/IMdEditor/IMdEditor.vue'
import IMdViewer from '@/components/bytemd/IMdViewer/IMdViewer.vue'

const value = ref('## Markdown Basic Syntax\n' +
  '\n' +
  'I just love **bold text**. Italicized text is the _cat\'s meow_. At the command prompt, type `nano`.\n' +
  '\n' +
  'My favorite markdown editor is [ByteMD](https://github.com/bytedance/bytemd).\n' +
  '\n' +
  '1. First item\n' +
  '2. Second item\n' +
  '3. Third item\n' +
  '\n' +
  '> Dorothy followed her through many of the beautiful rooms in her castle.\n' +
  '\n' +
  '```js\n' +
  'import { Editor, Viewer } from \'bytemd\';\n' +
  'import gfm from \'@bytemd/plugin-gfm\';\n' +
  '\n' +
  'const plugins = [\n' +
  '  gfm(),\n' +
  '  // Add more plugins here\n' +
  '];\n' +
  '\n' +
  'const editor = new Editor({\n' +
  '  target: document.body, // DOM to render\n' +
  '  props: {\n' +
  '    value: \'\',\n' +
  '    plugins,\n' +
  '  },\n' +
  '});\n' +
  '\n' +
  'editor.on(\'change\', (e) => {\n' +
  '  editor.$set({ value: e.detail.value });\n' +
  '});\n' +
  '```\n' +
  '\n' +
  '## GFM Extended Syntax\n' +
  '\n' +
  'Automatic URL Linking: https://github.com/bytedance/bytemd\n' +
  '\n' +
  '~~The world is flat.~~ We now know that the world is round.\n' +
  '\n' +
  '- [x] Write the press release\n' +
  '- [ ] Update the website\n' +
  '- [ ] Contact the media\n' +
  '\n' +
  '| Syntax    | Description |\n' +
  '| --------- | ----------- |\n' +
  '| Header    | Title       |\n' +
  '| Paragraph | Text        |\n' +
  '\n' +
  '## Footnotes\n' +
  '\n' +
  'Here\'s a simple footnote,[^1] and here\'s a longer one.[^bignote]\n' +
  '\n' +
  '[^1]: This is the first footnote.\n' +
  '[^bignote]: Here\'s one with multiple paragraphs and code.\n' +
  '\n' +
  '    Indent paragraphs to include them in the footnote.\n' +
  '\n' +
  '    `{ my code }`\n' +
  '\n' +
  '    Add as many paragraphs as you like.\n')

</script>

<template>
  <div>
    <i-md-editor v-model:value="value" />
    <br />
    <i-card>
      <i-md-viewer :value="value" />
    </i-card>
  </div>
</template>

<style scoped lang="scss">

</style>
