Vue.component('userInfo', {
    data: function() {
        return {
            username: "",
            name: "",
            mobile: "",
            email: "",
            address: "",
            disable: true
        }
    },
    methods: {
        getUserInfo(){
            axios.get("/getUserInfo").then(
                r=>{
                    if (r.data.msg === "success"){
                        this.username = r.data.result.username;
                        this.name = r.data.result.name;
                        this.mobile = r.data.result.mobile;
                        this.email = r.data.result.email;
                        this.address = r.data.result.address;
                        this.$emit('update:username', r.data.result.username);
                    }
                }
            )
        },
        changeBtn(){
            this.disable = false
        },
        saveBtn(){
            this.disable = true
        }
    },
    mounted(){
        this.getUserInfo()
    },
    template: '      <div class="container-fluid">\n' +
        '\n' +
        '        <div class="row">\n' +
        '          <div class="col-lg-12">\n' +
        '            <div class="card">\n' +
        '              <div class="card-body">\n' +
        '                <hr>\n' +
        '                <form method="post" action="#" class="site-form">\n' +
        '                  <div class="form-group">\n' +
        '                    <label for="username">用户名</label>\n' +
        '                    <input type="text" class="form-control" name="username" id="username" v-bind:value="username" disabled="disabled" />\n' +
        '                  </div>\n' +
        '                  <div class="form-group">\n' +
        '                    <label for="name">姓名</label>\n' +
        '                    <input type="text" class="form-control" name="username" id="name" v-bind:value="name" disabled="disabled" />\n' +
        '                  </div>\n' +
        '                  <div class="form-group">\n' +
        '                    <label for="mobile">手机号</label>\n' +
        '                    <input type="text" class="form-control" name="username" id="mobile" v-bind:value="mobile" v-bind:disabled="disable" />\n' +
        '                  </div>\n' +
        '                  <div class="form-group">\n' +
        '                    <label for="email">邮箱</label>\n' +
        '                    <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="请输入正确的邮箱地址" v-bind:value="email" v-bind:disabled="disable">\n' +
        '                    <small id="emailHelp" class="form-text text-muted">请保证您填写的邮箱地址是正确的。</small>\n' +
        '                  </div>\n' +
        '                  <div class="form-group">\n' +
        '                    <label for="remark">地址</label>\n' +
        '                    <textarea class="form-control" name="remark" id="remark" rows="2" v-bind:value="address" v-bind:disabled="disable"></textarea>\n' +
        '                  </div>\n' +
        '                  <button type="button" class="btn btn-primary" id="update" v-on:click="changeBtn" v-bind:disabled="!disable">修改</button>\n' +
        '                  <button type="submit" class="btn btn-primary" id="save" v-bind:disabled="disable" v-on:click="saveBtn">保存</button>\n' +
        '                </form>\n' +
        '\n' +
        '              </div>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '\n' +
        '        </div>\n' +
        '\n' +
        '      </div>'
})
Vue.component('two',{
    template:'<h1>2</h1>'
})
new Vue({
    el:"#app",
    data:{
        comName:""
    }
})
// new Vue({ el: '#components' })
