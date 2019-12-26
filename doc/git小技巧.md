##git常用小技巧
1. [Git如何在不提交当前分支的情况下切换(如果不提交或者stash 就会出现切回master 会带上 dev 分支的代码)到其它分支进行操作——git stash](https://blog.csdn.net/AsheAndWine/article/details/79003270)
2. [线上 修复 tag 上的bug](https://blog.csdn.net/qq_32157851/article/details/95942657) [demo02](https://www.jianshu.com/p/a3bb6aa78228) [demo](https://blog.masterliu.net/git-retag/) [demo01](https://blog.leapmie.com/archives/152/)
   1. 以tag为基准创建分支 git checkout -b branch_name tag_name
   2. 修改分支，以分支 打一个tag  git tag <tagName>  推送远程 git push origin <tagName>
   3. 主干合并 分支 修改的bug
3. [直接分支操作](https://www.cnblogs.com/jswang/p/9044263.html)

4. [Tag标签 系统版本号管理](https://www.jianshu.com/p/aa74226b5965)