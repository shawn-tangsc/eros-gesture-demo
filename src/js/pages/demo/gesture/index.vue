/**
* Created by tangsicheng on 2018/5/22.
*/
<template>

    <div>
        <wxc-button text="创建手势密码"
                    style="margin-left: 24px;margin-top: 20px;"
                    type="blue"
                    @wxcButtonClicked="addGesture"></wxc-button>

        <wxc-button text="校验手势密码"
                    style="margin-left: 24px;margin-top: 20px;"
                    type="blue"
                    @wxcButtonClicked="checkGesture"></wxc-button>

    </div>
</template>

<script>
    import {WxcButton } from 'weex-ui'
    const hmGesUnlock = weex.requireModule('hmGesUnlock');
    export default {
        components: {WxcButton},
        created() {

        },
        data() {
            return {}
        },
        methods: {
            addGesture(){
                let that = this
                hmGesUnlock.addGesturePage(function (flag) {
                    that.$notice.toast({
                        message: flag
                    });
                });
            },
            checkGesture(){
                let that = this
                hmGesUnlock.checkGesturePage(function (flag) {
                    that.$notice.toast({
                        message: flag
                    });
                });
            }

        }
    }
</script>

<style>


</style>
