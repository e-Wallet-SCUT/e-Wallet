
//在这里写新的panel的样式。
Vue.component("return", {
    template: `
<div>
<el-alert
    title="余额不足"
    type="error">
  </el-alert>
</div>

`,


    data: function () {



    },

    methods:{ //跳转页面

        hreftwo(){

            this.$router.push({ path:'/'  })

        }

    },


    created(){
        this.hreftwo()
    }



});



