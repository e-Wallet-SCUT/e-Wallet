
//在这里写新的panel的样式。
Vue.component("password", {
    template: `
    <div class="password">
        <el-input placeholder="请输入密码" v-model="input" show-password></el-input>
        <el-button type="primary" >主要按钮</el-button>
    </div>

`,

    data:function(){
        input:""
    },

    // method:{
    //     password(){
    //         var input = this.input;
    //         // axios.post()
    //     }
    // }



});



