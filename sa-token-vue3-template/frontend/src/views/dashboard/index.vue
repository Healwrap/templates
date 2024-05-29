<script lang="ts" setup>
import { onMounted, ref } from 'vue'
import ITable from '@/components/ITable/ITable.vue'
import IPageHeader from '@/components/IPageHeader/IPageHeader.vue'
import useEnterAnimation from '@/hooks/useEnterAnimation'
import { useUserStore } from '@/stores'

const userStore = useUserStore()
const userInfo = ref(userStore.userInfo)
const dataSource = ref([
  {
    key: 1,
    taskNum: 'T 23121101',
    taskName: '任务A',
    createTime: '2023-12-11 15:23:23',
    updateTime: '2023-12-11 15:23:23',
    status: '进行中',
  },
  {
    key: 2,
    taskNum: 'T 23121102',
    taskName: '任务B',
    createTime: '2023-12-11 15:23:23',
    updateTime: '2023-12-11 15:23:23',
    status: '已完成',
  },
  {
    key: 3,
    taskNum: 'T 23121102',
    taskName: '任务C',
    createTime: '2023-12-11 15:23:23',
    updateTime: '2023-12-11 15:23:23',
    status: '已完成',
  },
  {
    key: 4,
    taskNum: 'T 23121102',
    taskName: '任务D',
    createTime: '2023-12-11 15:23:23',
    updateTime: '2023-12-11 15:23:23',
    status: '已完成',
  },
  {
    key: 5,
    taskNum: 'T 23121102',
    taskName: '任务E',
    createTime: '2023-12-11 15:23:23',
    updateTime: '2023-12-11 15:23:23',
    status: '已完成',
  },
])
const columns = ref([
  {
    title: '序号',
    dataIndex: 'key',
  },
  {
    title: '任务编号',
    dataIndex: 'taskNum',
    key: 'taskNum',
  },
  {
    title: '任务名称',
    dataIndex: 'taskName',
    key: 'taskName',
  },
  {
    title: '创建时间',
    dataIndex: 'createTime',
    key: 'createTime',
  },
  {
    title: '最后更新时间',
    dataIndex: 'updateTime',
    key: 'updateTime',
  },
  {
    title: '任务状态',
    dataIndex: 'status',
    key: 'status',
  },
  {
    title: '操作',
    key: 'action',
    slots: { customRender: 'action' },
  },
])
onMounted(() => {
  useEnterAnimation('.ant-space-item', { type: 'y' })
})
</script>

<template>
  <div class="dashboard">
    <div class="content">
      <a-space direction="vertical" size="large" style="width: 100%">
        <i-page-header
          :sub-title="$t('app.welcome')"
          class="dashboard-page-header"
          style="width: 100%"
          :title="userInfo.nickname"
        >
          <div class="header-wrapper">
            <div class="avatar">
              <div class="avatar-img">
                <Icon icon="UserOutlined" />
              </div>
            </div>
            <div class="title-wrapper">
              <div class="title">早安, {{ userInfo.nickname }}, 开始您一天的工作吧！</div>
              <div class="sub-title">今日晴，20℃ - 32℃！</div>
            </div>
          </div>
        </i-page-header>
        <div class="card-panel">
          <i-card class="card-item">
            <div class="container">
              <Icon icon="ClearOutlined" :size="65" />
            </div>
            <div class="card-header">
              <span>示例一</span>
              <span>示例一示例一示例一</span>
            </div>
            <span class="statistics">23</span>
            <div class="action">
              <span>查看</span>
            </div>
          </i-card>
          <i-card class="card-item">
            <div class="container">
              <Icon icon="AppstoreOutlined" :size="65" />
            </div>
            <div class="card-header">
              <span>示例一</span>
              <span>示例一示例一示例一</span>
            </div>
            <span class="statistics">15</span>
            <div class="action">
              <span>查看</span>
            </div>
          </i-card>
          <i-card class="card-item">
            <div class="container">
              <Icon icon="DeleteOutlined" :size="65" />
            </div>
            <div class="card-header">
              <span>示例一</span>
              <span>示例一示例一示例一</span>
            </div>
            <span class="statistics">4</span>
            <div class="action">
              <span>查看</span>
            </div>
          </i-card>
          <i-card class="card-item">
            <div class="container">
              <Icon icon="MessageOutlined" :size="65" />
            </div>
            <div class="card-header">
              <span>示例一</span>
              <span>示例一示例一示例一</span>
            </div>
            <span class="statistics">99+</span>
            <div class="action">
              <span>查看</span>
            </div>
          </i-card>
        </div>
        <i-card>
          <i-table :columns="columns" :data-source="dataSource">
            <template #title-left>
              <Icon icon="ContactsOutlined" />
              任务列表
            </template>
            <template #title-right>
              <a-button type="primary">
                <Icon icon="PlusCircleOutlined" />
                新建任务
              </a-button>
            </template>
            <template #action>
              <a-button type="link">
                <Icon icon="EditOutlined" />
              </a-button>
              <a-button type="link">
                <Icon icon="DeleteOutlined" />
              </a-button>
            </template>
          </i-table>
        </i-card>
      </a-space>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/styles/theme.scss';

.dashboard {
  .dashboard-page-header {
    width: 100%;
    @include useTheme {
      background: getModeVar('cardBgColor');
    }

    .header-wrapper {
      display: flex;
      align-items: center;
      justify-content: flex-start;
      width: 100%;
      height: 100%;
      padding: 20px;
      box-sizing: border-box;

      @media screen and (max-width: 768px) {
        flex-direction: column;
        justify-content: center;
        align-items: center;
      }

      .avatar {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 70px;
        height: 70px;
        border-radius: 999px;
        background: #ffffff;
        margin-right: 20px;

        @media screen and (max-width: 768px) {
          margin-right: 0;
          margin-bottom: 20px;
        }

        .avatar-img {
          display: flex;
          justify-content: center;
          align-items: center;
          width: 70px;
          height: 70px;
          border-radius: 999px;
          background: #1677ff;
          font-size: 30px;
          color: #ffffff;
        }
      }

      .title-wrapper {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: flex-start;
        width: 100%;
        height: 100%;

        .title {
          font-size: 20px;
          font-weight: 600;
          margin-bottom: 10px;
        }

        .sub-title {
          font-size: 14px;
          font-weight: 400;
          color: #999999;
        }
      }
    }
  }

  .card-panel {
    width: 100%;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(0, 1fr));
    grid-gap: 24px;

    @media screen and (max-width: 1600px) {
      grid-template-columns: 1fr 1fr;
    }

    @media screen and (max-width: 768px) {
      grid-template-columns: 1fr;
    }

    .card-item {
      position: relative;
      height: 200px;
      $colors: (
        1: rgb(250, 125, 121),
        2: rgb(84, 172, 208),
        3: rgb(175, 80, 208),
        4: rgb(255, 204, 102),
      );
      @each $key, $value in $colors {
        &:nth-child(#{$key}) {
          @include useTheme {
            background:
              radial-gradient(178.94% 106.41% at 26.42% 106.41%, $value 0%, rgba(getModeVar('cardBgColor'), 0) 71.88%)
                /* warning: gradient uses a rotation that is not supported by CSS and may not behave as expected */,
              getModeVar('cardBgColor');
          }
        }
      }

      box-shadow:
        0px 155px 62px rgba(0, 0, 0, 0.01),
        0px 87px 52px rgba(0, 0, 0, 0.05),
        0px 39px 39px rgba(0, 0, 0, 0.09),
        0px 10px 21px rgba(0, 0, 0, 0.1),
        0px 0px 0px rgba(0, 0, 0, 0.1);
      border-radius: 23px;
      transition: all 0.8s cubic-bezier(0.15, 0.83, 0.66, 1);
      cursor: pointer;

      &:hover {
        transform: scale(1.05);
      }

      .container {
        width: 250px;
        height: 250px;
        position: absolute;
        right: -35px;
        top: -50px;
        display: flex;
        align-items: center;
        justify-content: center;
        transform: scale(0.7);
      }

      .card-header {
        display: flex;
        flex-direction: column;
        gap: 10px;

        span {
          &:first-child {
            word-break: break-all;
            font-weight: 800;
            font-size: 22px;
            line-height: 135%;
            @include useTheme {
              color: rgba(getModeVar('textColor'), 0.9);
            }
          }

          &:last-child {
            font-weight: 600;
            font-size: 15px;
            line-height: 135%;
            @include useTheme {
              color: rgba(getModeVar('textColor'), 0.5);
            }
          }
        }
      }

      .statistics {
        position: absolute;
        left: 25px;
        bottom: 12px;
        font-weight: 700;
        font-size: 64px;
        line-height: 77px;
        @include useTheme {
          color: rgba(getModeVar('textColor'), 0.9);
        }
      }

      .action {
        width: 80px;
        height: 36px;
        position: absolute;
        right: 25px;
        bottom: 25px;
        display: flex;
        align-items: center;
        justify-content: center;
        background: rgba(0, 0, 0, 0.06);
        border-radius: 9px;

        span {
          font-weight: 700;
          font-size: 13px;
          line-height: 134.49%;
          @include useTheme {
            color: rgba(getModeVar('textColor'), 0.5);
          }
        }
      }
    }
  }
}
</style>
