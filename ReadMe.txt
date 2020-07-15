测试git拉取源码到本地、提交代码到远程，更新源码到远程，本地合并前后端代码
怎么提交到本地的git仓库？
1,使用idea链接Git远程仓库[File-->Settings-->gitHub(输入账号、密码)]
2,把这个项目交给git管理,点击工具栏[VCS-->import into version control-->create Git Repository]
  创建一个git,选择交给git管理的项目点击OK
3、如果创建成功类的颜色就会变成【褐色】
4、添加到git,项目名称右键Git-->+add当添加成功类就会变成【绿色】
5、提交到本地git的仓库[Git-->commit Directory]添加描述信息点击Commit按钮提交，提交成功类就会变成【黑色】
怎么提交到远程的git仓库？
1.在https://github.com中创建一个新项目名称[sentinel-test]
2.复制SSH中的https://github.com/XXX/xxx.git
3.然后到项目中选择项目名称[Git-->Repository-->Push
(弹出一个对话框点击Define remote-->[弹出一个Define remote输入框输入Name自定义和刚刚复制的URL地址黏贴到这来点击OK])]
最后点击Push按钮出现Push Successful窗口，然后回到GitHub网页刷新。这样我们就把刚刚那个项目添加到git远程服务器上。
我们怎么拉取Git上的项目到本地？
1.点击GitHub网页上Clone or download按钮复制输入框中的https://github.com/XXX/xxx.git
2.到idea中选择工具栏中[VCS-->checkout from Version Control-->Git]会弹出一个对话框在URL输入框中输入刚刚复制的内容
  在Directory中输入我们从远程GitHub中拉取到本地保存的位置，点击clone按钮OK，然后会弹出一个对话框让我们选择是否现在打开
  下载的项目。
3.然后就可以编写代码再次交给Git管理，点击项目名称[Git-->+add]添加，然后在把他提交到本地的Git仓库，填写编辑信息点击commit按钮
4.提交完毕类变成黑色，然后点击项目名称添加到远程仓库[Git-->Repository-->push]弹出一个对话框点击Push按钮
5.最后在右下角弹出一个Push successful对话框表示添加成功，然后进入远程git页面刷新看一下是否提交成功。
怎么把一个前端和后端两个分支合并成一个项目
1，点击项目名称创建一个前端分支名称自拟[Git-->Repository-->Branches...]弹出对话框点击+New Breach
   弹出对话框输入New branch name:web名称写前端代码
2，然后在项目中创建一个新的文件夹存放web页面
3，把这个项目提交到本地仓库[Git-->commit Directory]弹出对话框输入编辑信息web前端页面修改点击commit按钮
4，把这个项目切换为后台项目[Git-->Repository->Branches...]弹出对话框选择master选择checkout
5,修改后台项目源码
6，点击项目名称提交到本地仓库[Git-->commit Directory]弹出对话框输入编辑信息后端页面修改点击commit按钮
7，如果前后端把代码写好了，我们就可以把刚才前端分支和后端分支合并到一个分支中
   [Git-->Repository-->Branches...]弹出对话框选择web中的Merge into Current
8,这样前端和后端就合并到同一个分支上
9，点击项目名称[Git-->Repository-->Branches...]弹出对话框选web分支中的Delete
10，现在就剩一个主分支，点击项目名称[Git-->Repository-->Push]弹出对话框点击push在提交到远程git仓库中
11，进入GitHub页面在刷新一下页面
我们在使用idea提交远程GitHub项目时候必须先拉取pull项目，测试没有问题然后才可以提交push到远程GitHub上

使用idea整合你的git并且完成版本库的创建以及基础操作提交
为什么要选择添加，什么时候要选择添加？
1.当一个文件从无到有的时候要选择添加，下次在去修改就不用了，像客户端一样直接提交。
2.只有在项目中新建文件(包括类文件，静态文件从无到有需要添加)
3.右键选择[Git-->+add]添加类的颜色[绿色]
4.右键选择项目[Git-->commit Directory]提交，提交到这个分支上去，点击提交的时候要求填写注释
5.填写好注释点击commit之后发现颜色没有了为[黑色]

idea同步远程仓库
1.在https://github.com中创建一个新项目名称[sentinel-test]
2.创建完成发现远程仓库是空的，只有一些命令和链接。
3.通过SSH链接
4，同步到远程仓库[Git-->Repository-->Push]
5.配置仓库路径，push的前提是你的本地仓库已经add已经commit[Git-->Repository-->Push]
6.


