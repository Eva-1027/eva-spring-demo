# spring初始化bean的多级缓存理解和整理
对我来说，实在是不好理解，看了基本上一下午和各种资料，粗浅的有了一点自己的理解，（还只是到为什么用二级缓存的理解，实在是过于粗浅了，没办法，脑子好久没用了😭）

## 一些初始概念，脑子🧠，启动！
- 为什么要缓存？
  - 最直观的原因是提高应用启动的速度和性能，缓存的实际实现只是一个concurrentHashMap(HashMap),相当于创建一个快速查找实例的“字典“，需要时可以直接获取。（？这个现在有点持怀疑态度？）
  - 再就是为了解决循环依赖的问题，这个后面会讲到。
- 当我们在说一个创建bean的时候，要区分好**实例化**（执行构造方法）和**属性注入**（populate需要的依赖和aware需要的东西）和**初始化**（before/postConstruct/initializingBean/init-method/after）。

## 明确几个*属性注入*的过程中的规则：
- 引入两种类型的缓存：
  - Map > singletonObjects: 一级缓存，存的是beanName以及初始化好的完整的bean。
  - Map > earlySingletonObjects: 二级缓存，粗浅理解为刚实例化好，还没有进行属性注入的bean。

- 当一个bean在属性注入时需要另一个bean时，需要的*通常来说*都是一个完成*初始化*的完整的bean，所以会先尝试从一级缓存中获取，但是如果没有，
会尝试从二级缓存中获取，如果能够获取到，可以进行注入并认为注入完成，直接送入初始化阶段（。

- 为什么会引入三级缓存：增加二级缓存，不能解决有代理对象时的循环依赖。
原因是放进二级缓存earlySingletonObjects中的bean是实例化后的bean，*而放进一级缓存singletonObjects中的bean是代理对象*（代理对象在BeanPostProcessor#postProcessAfterInitialization中返回），*两个缓存中的bean不一致*。

- *总结*： 所以singletonFactories的目的才是解决有代理对象的循环依赖问题，二级缓存解决的是有循环依赖的普通bean的问题。