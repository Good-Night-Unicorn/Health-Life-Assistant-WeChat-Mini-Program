<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230831/34dfcf1d863242a19ac975db1b21d8b0.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
      <el-form :style='{"border":"1px solid #f6f6f6","minHeight":"720px","padding":"50px 20px 50px 650px","boxShadow":"0 10px 10px rgba(0, 0, 0, .1)","margin":"0","borderRadius":"35px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230804/4d9bed4dce5944128d26c145f0e7889f.png) no-repeat center top / 100% 100%","width":"1200px","fontSize":"16px","position":"relative","height":"auto"}'>
        <div v-if="true" :style='{"padding":"0px","margin":"0px auto 50px","borderColor":"#ddd","color":"#f46f8b","textAlign":"left","display":"inline-block","background":"none","borderWidth":"0px","width":"50%","lineHeight":"40px","fontSize":"30px","borderStyle":"solid","fontWeight":"600"}' class="title-container">健康生活助手微信小程序的设计与实现登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"75%","margin":"0 auto 30px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>用户名：</div>
          <input :style='{"border":"0px solid rgba(167,142,68,.2)","padding":"0 10px","boxShadow":"0 5px 5px rgba(60, 60, 60, .1)","borderColor":"#f9f9f9","color":"#666","outline":"0px solid #efefef","outlineOffset":"0px","borderRadius":"30px","background":"none","borderWidth":"1px 0 0","width":"100%","fontSize":"inherit","borderStyle":"solid","height":"44px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"75%","margin":"0 auto 30px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>密码：</div>
          <input :style='{"border":"0px solid rgba(167,142,68,.2)","padding":"0 10px","boxShadow":"0 5px 5px rgba(60, 60, 60, .1)","borderColor":"#f9f9f9","color":"#666","outline":"0px solid #efefef","outlineOffset":"0px","borderRadius":"30px","background":"none","borderWidth":"1px 0 0","width":"100%","fontSize":"inherit","borderStyle":"solid","height":"44px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>

        <div :style='{"boxShadow":"0 5px 5px rgba(60, 60, 60, .1)","padding":"0 30px","margin":"30px auto","borderColor":"#f9f9f9","borderRadius":"44px","textAlign":"left","borderWidth":"1px 0 0","width":"75%","fontSize":"inherit","lineHeight":"44px","borderStyle":"solid"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>

		
        <div :style='{"margin":"30px auto 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"75%","fontSize":"18px","justifyContent":"center"}'>
          <el-button v-if="loginType==1" :style='{"border":"1px solid #fff","cursor":"pointer","padding":"0 0 0 20px","margin":"0","color":"#fff","textAlign":"center","bottom":"150px","letterSpacing":"20px","outline":"none","borderRadius":"50px","left":"170px","background":"none","width":"240px","fontSize":"24px","position":"absolute","height":"66px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
		this.$router.push({path:'/register',query:{pageFlag:'register'}})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		
		this.loginPost()
    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
			}
		});
	},
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20230831/34dfcf1d863242a19ac975db1b21d8b0.jpg);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 0px solid rgba(167,142,68,.2);
		padding: 0 10px;
		color: #666;
		font-size: inherit;
		border-color: #f9f9f9;
		outline-offset: 0px;
		border-radius: 30px;
		box-shadow: 0 5px 5px rgba(60, 60, 60, .1);
		outline: 0px solid #efefef;
		background: none;
		width: 100%;
		border-width: 1px 0 0;
		border-style: solid;
		height: 44px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border: 1px solid rgba(64, 158, 255, 1);
		padding: 0 10px;
		box-shadow: 0 0 6px rgba(64, 158, 255, .5);
		outline: 1px solid #efefef;
		color: rgba(64, 158, 255, 1);
		width: 288px;
		font-size: 14px;
		outline-offset: 4px;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border-radius: 50px;
  	  	padding: 0 10px;
  	  	box-shadow: 0 5px 5px rgba(60, 60, 60, .1);
  	  	outline: none;
  	  	color: #666;
  	  	background: none;
  	  	width: calc(100% - 90px);
  	  	font-size: inherit;
  	  	border-color: #f9f9f9;
  	  	border-width: 1px 0 0;
  	  	border-style: solid;
  	  	height: 44px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #fcaeb9;
        border-color: #f697a5;
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 16px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: rgba(50,50,50,1);
        font-size: 16px;
      }
}

</style>
