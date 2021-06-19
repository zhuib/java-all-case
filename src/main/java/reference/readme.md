### 软引用和弱引用的应用场景
假如有一个应用需要读取大量的本地图片
* 如果每次读取图片都从硬盘读取则会严重影响性能,
* 如果一次性全部加载到内存中又可能造成内存溢出

此时使用软引用可以解决这个问题。

设计思路是:用一个 HashMap来保存图片的路径和相应图片对象关联的软引用之间的映射关系,在内存不足时,
JM会自动回收这些缓存图片对象所占用的空间,从而有效地避免了OOM的问题

Map<String, SoftReference< Bitmap>> imageCache= new HashMap<String, SoftReference<Bitmap>>()