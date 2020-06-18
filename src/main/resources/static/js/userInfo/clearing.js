
//在这里写新的panel的样式。
Vue.component("clearing", {
    template: ` 
 <div>
  <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="entityId"
      label="银行id"
      width="180">
    </el-table-column>
    <el-table-column
      prop="entityName"
      label="银行名称"
      width="180">
    </el-table-column>
    
      <el-table-column
      prop="entityBalance"
      label="当日余额">
    </el-table-column>
    
    <el-table-column
      prop="entityDayPosition"
      label="当日头寸">
    </el-table-column>
  </el-table>
 </div>
 
`,


    data: function () {
        return {


            tableData: []


        }

    },


    methods:{

     getEntity() {
         axios.get('getAllAmount').then(response => {

             this.tableData = response.data;

         })
     }
     },



    created(){
        this.getEntity();
    },



});



