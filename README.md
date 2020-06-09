# e-Wallet

项目更新流程：
首先在本地，打开Git bash，找一个目录，git clone https://github.com/JSYBruce/e-Wallet
这就获取了该项目的内容。

然后，用IntelliJ打开项目，对项目进行修改，右上角有一个Commit选项，在Commit的时候，选择Commit and Pull即可自动更新项目。

切记：在进行任何更新操作前，首先pull一下最新内容，以防覆盖。（不过github会自动检测这种情况）



·····
Elasticsearch在配置文件中进行连接，通过service进行具体操作实现。

前端index为商场界面，pay是支付界面。

目前支付页面跳转的api是 /pay/{title}/{price}/{traget}  当然还需要获取用户的账户名，可以考虑用你之前说的api，不过我还没试过。
支付的api是 /getpay/ 然后传一些数据到后台处理。之后跳转到支付成功页面。
电子商城就目前在index ；
elasticsearch的数据库会有4个字段，title, price, img, target。
mysql负责写入支付信息。
····
