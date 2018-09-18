# cigna-spring-aop

# Build Instructions
```mvn clean package``` will produce the file ```target/cigna-spring-aop-1.0.0.jar```

# Executing the reproducer
```java -jar target/cigna-spring-aop-1.0.0.jar``` will produce output like below.
The stacktrace is getting dumped out on purpose in order to show that the invoked service method is actually being wrapped by a CGLIB class.

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.0.5.RELEASE)

2018-09-18 10:08:47.715  INFO 12096 --- [           main] dynatrace.Application                    : Starting Application v1.0.0 on TAG009441360369 with PID 12096 (C:\workspaces\data\FTS-SVN\akka-http\cigna-spring-aop\target\cigna-spring-aop-1.0.0.jar started by Reinhard.Pilz in C:\workspaces\data\FTS-SVN\akka-http\cigna-spring-aop)
2018-09-18 10:08:47.724  INFO 12096 --- [           main] dynatrace.Application                    : No active profile set, falling back to default profiles: default
2018-09-18 10:08:47.843  INFO 12096 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@b48fee03: startup date [Tue Sep 18 10:08:47 CEST 2018]; root of context hierarchy
2018-09-18 10:08:49.572  INFO 12096 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2018-09-18 10:08:49.612  INFO 12096 --- [           main] dynatrace.Application                    : Started Application in 2.863 seconds (JVM running for 3.982)
2018-09-18 10:08:49.627  INFO 12096 --- [           main] dynatrace.Controller                     : execute
2018-09-18 10:08:49.681  INFO 12096 --- [           main] dynatrace.TransactionAspect              : manageTransaction
2018-09-18 10:08:49.683  INFO 12096 --- [           main] dynatrace.CgnTransactionManager          : getTransactionWithoutException
2018-09-18 10:08:49.686  INFO 12096 --- [           main] dynatrace.TransactionAspect              : No transaction found, creating the new one
2018-09-18 10:08:49.702  INFO 12096 --- [           main] dynatrace.TransactionAspect              : getTransactionalAnnotation
2018-09-18 10:08:49.715  INFO 12096 --- [           main] dynatrace.DBContext                      : init
2018-09-18 10:08:49.715  INFO 12096 --- [           main] dynatrace.Driver                         : session
2018-09-18 10:08:49.716  INFO 12096 --- [           main] dynatrace.CgnTransactionManager          : init
2018-09-18 10:08:49.718  INFO 12096 --- [           main] dynatrace.TransactionAspect              : manageTransaction
2018-09-18 10:08:49.719  INFO 12096 --- [           main] dynatrace.CgnTransactionManager          : getTransactionWithoutException
2018-09-18 10:08:49.781  INFO 12096 --- [           main] d.ContextDefinitionGraphServiceImpl      : saveSourceContext
java.lang.Throwable
        at java.lang.Thread.dumpStack(Thread.java:488)
        at dynatrace.ContextDefinitionGraphServiceImpl.saveSourceContext(ContextDefinitionGraphServiceImpl.java:16)
        at dynatrace.ContextDefinitionGraphServiceImpl$$FastClassBySpringCGLIB$$857b9838.invoke(<generated>)
        at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)
        at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:746)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
        at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:88)
        at dynatrace.TransactionAspect.manageTransaction(TransactionAspect.java:37)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:90)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:55)
        at java.lang.reflect.Method.invoke(Method.java:508)
        at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)
        at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)
        at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:70)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:174)
        at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:88)
        at dynatrace.TransactionAspect.lambda$manageTransaction$0(TransactionAspect.java:45)
        at dynatrace.TransactionAspect$$Lambda$164.0000000015127270.work(Unknown Source)
        at dynatrace.Session.writeTransaction(Session.java:16)
        at dynatrace.TransactionAspect.manageTransaction(TransactionAspect.java:66)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:90)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:55)
        at java.lang.reflect.Method.invoke(Method.java:508)
        at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)
        at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)
        at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:70)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:174)
        at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:92)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)
        at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:688)
        at dynatrace.ContextDefinitionGraphServiceImpl$$EnhancerBySpringCGLIB$$248af14c.saveSourceContext(<generated>)
        at dynatrace.Controller.execute(Controller.java:18)
        at dynatrace.Application.lambda$commandLineRunner$0(Application.java:21)
        at dynatrace.Application$$Lambda$146.0000000014D698D0.run(Unknown Source)
        at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:818)
        at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:802)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:341)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1277)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1265)
        at dynatrace.Application.main(Application.java:14)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:90)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:55)
        at java.lang.reflect.Method.invoke(Method.java:508)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:48)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:87)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:50)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:51)
2018-09-18 10:08:49.888  INFO 12096 --- [           main] dynatrace.CgnTransactionManager          : destroy
2018-09-18 10:08:49.889  INFO 12096 --- [           main] dynatrace.DBContext                      : destroy
2018-09-18 10:08:49.896  INFO 12096 --- [       Thread-9] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@b48fee03: startup date [Tue Sep 18 10:08:47 CEST 2018]; root of context hierarchy
2018-09-18 10:08:49.901  INFO 12096 --- [       Thread-9] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
```
