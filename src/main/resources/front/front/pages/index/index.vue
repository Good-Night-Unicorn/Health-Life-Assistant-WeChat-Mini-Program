<template>
<view class="content">
	<view :style='{"minHeight":"100vh","padding":"40rpx 0px 0","overflow":"hidden","alignItems":"flex-start","flexWrap":"wrap","background":"#ffecf1","flexDirection":"row","display":"flex","width":"100%","height":"auto"}'>
		<view class="list-swiper-4" :style='{"width":"100%","margin":"0 0 40rpx","position":"relative","height":"360rpx"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
			<view :style='{"overflow":"hidden","top":"0%","left":"0%","background":"#fff","width":"100%","position":"absolute","height":"360rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__zoomOutRight' : (numList4 == index  ? 'animate__zoomInLeft' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view :style='{"padding":"8rpx 20rpx 80rpx","margin":"-20rpx 0 0 0","color":"#fff","textAlign":"center","display":"none","transform":"translate3d(-50%, -50%, 0)","top":"100%","left":"50%","background":"rgba(255, 255, 255, 0.3)","width":"100%","lineHeight":"1.5","fontSize":"28rpx","position":"absolute"}'>{{ swiper.title }}</view>
			</view>
			<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"2%","background":"rgba(0,0,0,.0)","display":"flex","width":"100%","position":"absolute","justifyContent":"center","height":"40rpx"}'>
				<block v-for="(swiper,index) in swiperList" :key="index">
					<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#ff9593","height":"16rpx"}'></text>
					<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
				</block>
			</view>
		</view>


		<!-- menu -->
        <view style="width: 100%" v-if="swiperMenuList.length">
            <swiper :style='{"padding":"0","margin":"0 auto","borderRadius":"0px","flexWrap":"wrap","background":"#fff","display":"flex","width":"calc(100% - 48rpx)","justifyContent":"space-between"}' class="swiper">
                <swiper-item v-for="(swiper,index) in (new Array(Number(Math.ceil(swiperMenuList.length / (rows * column)))).fill('').map((val, i) => i+1))" :key="index">
                    <view v-for="(row, index1) in (new Array(Number(rows)).fill('').map((val, i) => i+1))" :key="index1" style="display: flex;flex-wrap: wrap;">
                        <view v-for="(col, index2) in (new Array(Number(column)).fill('').map((val, i) => i+1))" :key="index2" v-if="(((row+rows*(swiper-1) -1)*column + col -1)<swiperMenuList.length)" :style='{"width":"25%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list">
                            <view :class="swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].appFrontIcon" @tap="onPageTap2('../'+swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].tableName+'/list')" :style='{"padding":"0","margin":"0px auto","color":"#ff9593","borderRadius":"100%","background":"#fff","display":"block","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","height":"64rpx"}'>
                            </view>
                            <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].menu.split("列表")[0]}} </view>
                        </view>
                    </view>
                </swiper-item>
            </swiper>
        </view>
		<!-- menu -->
		
		<!-- 关于我们 -->
		<view :style='{"padding":"0 0 24rpx","margin":"240rpx auto 0","borderRadius":"16rpx","alignItems":"flex-start","flexWrap":"wrap","background":"#fff","flexDirection":"column","display":"flex","width":"calc(100% - 48rpx)","position":"relative","height":"auto","order":"1"}'>
			<view :style='{"margin":"0px 0 0","color":"#fff","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231220/5ac7828ca1c0499b9bb7cebb17053c19.jpg) no-repeat center top / 100% 100%","width":"100%","fontSize":"32rpx","lineHeight":"80rpx","fontWeight":"600","height":"120rpx"}'>{{aboutUsDetail.title}}</view>
			<view :style='{"width":"100%","margin":"-48rpx 0 0","lineHeight":"1","fontSize":"28rpx","color":"#fff","textAlign":"center"}'>{{aboutUsDetail.subtitle}}</view>
			<view :style='{"padding":"0 20rpx","margin":"60rpx 0 0","borderRadius":"0","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
				<img :style='{"width":"31%","margin":"0 0px","objectFit":"cover","borderRadius":"60rpx","display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
				<img :style='{"width":"31%","margin":"0 0px","objectFit":"cover","borderRadius":"60rpx","display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2"">
				<img :style='{"width":"31%","margin":"0 0px","objectFit":"cover","borderRadius":"60rpx","display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3"">
			</view>
			<view :style='{"padding":"24rpx","margin":"0px 0 0px 0","color":"rgb(102, 102, 102)","borderRadius":"0","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","order":"2"}' v-html="aboutUsDetail.content"></view>
			<view :style='{"border":"0","padding":"0 30rpx","margin":"40rpx auto 20rpx","borderRadius":"8rpx","textAlign":"center","background":"#a5ccc4","display":"none","width":"auto","lineHeight":"56rpx","order":"3"}'>
			  <text :style='{"color":"#f5f5f5","fontSize":"24rpx"}'>更多</text>
			  <text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
			</view>
			<view :style='{"width":"100%","position":"absolute","top":"-200rpx","background":"url(http://codegen.caihongy.cn/20231220/f7e2906a88da4261917ac452b2a8858c.png) no-repeat center top /100% 100%","display":"block","height":"160rpx"}' />
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>

		<!-- 系统简介 -->
		<view :style='{"padding":"40rpx 0 0","margin":"40rpx auto","borderRadius":"16rpx","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20231219/03e5d1b3a78b4d658ec5da43a2021782.png) no-repeat center top / 100% auto,#ff9593","display":"flex","width":"calc(100% - 48rpx)","height":"auto","order":"4"}'>
			<view :style='{"padding":"12rpx 0 0","margin":"0 auto","color":"#fff","textAlign":"center","background":"none","width":"calc(100% - 48rpx)","lineHeight":"60rpx","fontSize":"32rpx","fontWeight":"600"}'>{{systemIntroductionDetail.title}}</view>
			<view :style='{"padding":"0 0 24rpx","margin":"0 auto 0px","color":"#fff","borderRadius":"0 0 40rpx 40rpx","textAlign":"center","background":"none","width":"calc(100% - 48rpx)","lineHeight":"1","fontSize":"28rpx"}'>{{systemIntroductionDetail.subtitle}}</view>
			<view :style='{"padding":"0px 48rpx 48rpx","borderRadius":"0 0 16rpx 16rpx","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20231219/6451fe6a21a1481e80e97f6019e6383c.png) repeat-y center top / 100% auto,#ff9593","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
				<img :style='{"width":"30%","margin":"0 0px","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
				<img :style='{"width":"30%","margin":"0 0px","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
				<img :style='{"width":"30%","margin":"0 0px","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
			</view>
			<view :style='{"padding":"48rpx 48rpx 24rpx","margin":"0 0 0px 0","color":"#333","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20231219/bd894ddfcb1445a484190d0867965273.png) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20231219/6451fe6a21a1481e80e97f6019e6383c.png) repeat-y center top / 100% auto,#ff9593","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' v-html="systemIntroductionDetail.content"></view>
			<view :style='{"border":"0","padding":"0 30rpx","margin":"0 auto","textAlign":"center","background":"#409EFF","display":"none","width":"auto","lineHeight":"56rpx","order":"3"}'>
			  <text :style='{"color":"#f5f5f5","fontSize":"24rpx"}'>更多</text>
			  <text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
			</view>
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>
		
		<!-- 商品推荐 -->
		<view class="listBox recommend" :style='{"width":"calc(100% - 48rpx)","padding":"0","margin":"40rpx auto 40rpx","borderRadius":"16rpx","background":"linear-gradient(0deg, rgba(255,218,228,1) 0%, rgba(255,150,148,1) 100%)","order":"2"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"left","background":"none","width":"100%","lineHeight":"116rpx","height":"116rpx"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx","fontWeight":"600"}'>活动信息推荐</view>
			</view>
			
			
			<!-- 样式3 -->
			<view class="list-box style3" :style='{"width":"100%","padding":"0 24rpx 24rpx","margin":"0","height":"auto"}'>
				<view @tap="onDetailTap('huodongxinxi',product.id)" v-for="(product,index) in huodongxinxilist" :key="index" class="list-item" :style='{"boxShadow":"0 4rpx 0px rgba(0,0,0,.1)","padding":"20rpx","margin":"0 0 40rpx","borderRadius":"16rpx","alignItems":"center","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
					<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"200rpx"}' class="list-item-image" mode="aspectFill" v-if="product.tupian.substring(0,4)=='http'" :src="product.tupian"></image>
					<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"200rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>
					<view class="list-item-body" :style='{"minHeight":"200rpx","padding":"0 0 0 20rpx","margin":"0","flexWrap":"wrap","display":"flex","width":"calc(100% - 200rpx)","position":"relative","height":"auto"}'>
						<view :style='{"padding":"0 0px","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.huodongmingcheng}}</view>
						<view :style='{"padding":"0 0px","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.huodongleixing}}</view>
						<view :style='{"padding":"0 0px","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">参与人数:{{product.canyurenshu}}</view>
						<view :style='{"width":"100%","padding":"0 0px","order":"6"}'>
						  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
						  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
						</view>
						<view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","display":"inline-block"}'>
						  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
						  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
						</view>
						<view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","display":"inline-block"}'>
						  <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
						  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.clicknum}}</text>
						</view>
					</view>
				</view>
			</view>
			
			  
			
			
			  
			

		</view>
		<!-- 商品推荐 -->
		
		<!-- 商品列表 -->
		<!-- 商品列表 -->
		
		<!-- 新闻资讯 -->
		<view class="listBox news" :style='{"width":"calc(100% - 48rpx)","padding":"24rpx 0","margin":"40rpx auto 40rpx","borderRadius":"16rpx","background":"linear-gradient(0deg, rgba(255,218,228,1) 0%, rgba(255,150,148,1) 100%)","order":"5"}'>
			<view class="title" :style='{"padding":"0 0px","margin":"0 auto","textAlign":"left","background":"none","display":"block","width":"calc(100% - 48rpx)","lineHeight":"92rpx","position":"relative","justifyContent":"space-between","height":"100rpx"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx"}'>公告信息</view>
				<view :style='{"position":"absolute","right":"0px","alignItems":"center","top":"0px","justifyContent":"center","display":"flex"}' @tap="onPageTap('news')">
				  <text :style='{"color":"#fff","fontSize":"28rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#fff","fontSize":"28rpx"}'></text>
				</view>
			</view>
		  
			
			
		  <!-- 样式4 -->
		  
		  <!-- 样式5 -->
		  
		  <!-- 样式6 -->
		  
		  <!-- 样式7 -->
		  
		  <!-- 样式8 -->
		  <view class="news-box5" :style='{"padding":"24rpx","margin":"0","color":"#999","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
			<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"padding":"32rpx 20rpx 16rpx","margin":"0 0 32rpx","borderColor":"#ff8785","borderRadius":"80rpx 12rpx","background":"#fff","borderWidth":"0 2rpx","width":"48%","borderStyle":"solid","height":"auto"}'>
			  <view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title ">{{item.title}}</view>
			  <view :style='{"padding":"0 0px","margin":"0 0 10rpx","overflow":"hidden","color":"#888","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","height":"96rpx"}' class="text">{{item.introduction}}</view>
			  <view :style='{"width":"100%","padding":"0 0px"}'>
			    <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
			    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime}}</text>
			  </view>
			  <view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","display":"inline-block"}'>
			    <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
			    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
			  </view>
			  <view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","display":"inline-block"}'>
			    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
			    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
			  </view>
			  <view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","display":"inline-block"}'>
			    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
			    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
			  </view>
			  <view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","display":"inline-block"}'>
			    <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
			    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
			  </view>
			</view>
		  </view>
		  
		  <!-- 样式9 -->

		</view>
		<!-- 新闻资讯 -->

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#ff9593","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                aboutUsDetail: {},
                systemIntroductionDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				huodongxinxilist: [],
				news: [],





















































			}
		},
		watch: {




















































		},
		mounted() {




















































		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},





















































		},
        async onLoad(){
            this.role = uni.getStorageSync("role");
            let table = uni.getStorageSync("nowTable");
            let res = await this.$api.session(table);
            this.user = res.data;
            this.tableName = table;
            let menus = menu.list();
            this.menuList = menus;
            this.menuList.forEach((item,key) => {
                if(key==0) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
            let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			
			this.prevNumList4 = this.swiperList.length - 1
			this.timerList4 = setInterval(this.autoPlayList4, 6000)

            this.getAboutUs();
            this.getSystemIntroduction();
			// 推荐信息
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},

		methods: {




















































			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 公告信息
				res = await this.$api.list('news', params)
				this.news = res.data.list
				
				
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				if(uni.getStorageSync("appUserid")) {
					res = await this.$api.recommend2('huodongxinxi', params);
				} else {
					res = await this.$api.recommend('huodongxinxi', params);
				}
				this.huodongxinxilist = res.data.list
				

			},
			autoPlayList4() {
				this.prevNumList4 = this.numList4
			
				this.numList4++
				if (this.numList4 == this.swiperList.length) this.numList4 = 0
			},
			touchStart(event) {
				this.startX = event.touches[0].clientX
				
				clearInterval(this.timerList4)
				this.flagList4 = true
			},
			touchMove(event) {
				const currentX = event.touches[0].clientX;
				const deltaX = currentX - this.startX;
				
				if (deltaX > 50) {
					// 向右滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4++
						if (this.numList4 == this.swiperList.length) this.numList4 = 0
					}
					
				} else if (deltaX < -50) {
					// 向左滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4--
						if (this.numList4 < 0) this.numList4 = this.swiperList.length - 1
					}
				}
			},
			touchEnd() {
				this.startX = 0
				
				this.timerList4 = setInterval(this.autoPlayList4, 6000)
				this.flagList4 = false
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
            async getSystemIntroduction() {
                let res = await this.$api.info('systemintro', 1)
                this.systemIntroductionDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}

</style>
