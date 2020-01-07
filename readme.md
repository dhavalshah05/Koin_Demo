[[toc]]
# Step 1 :- Setting up Koin

Add following dependencies to your app level **build.gradle** file.

```groovy
// Koin
implementation 'org.koin:koin-core:2.0.1'
implementation 'org.koin:koin-androidx-scope:2.0.1'
implementation 'org.koin:koin-androidx-viewmodel:2.0.1'
```

For latest version of Koin, please navigate to [Koin GitHub](https://github.com/InsertKoinIO/koin)

---
# Step 2 :- Creating Module

You can create a module using following syntex.

```kotlin
val applicationModule = module {
}
```

---
# Step 3 :- Providing Dependencies

You can provide dependencies from module using following syntex.

#### **[A] `single`**: To provide single instance for whole application.
```kotlin
val applicationModule = module {
    single<LoginRepository> { LoginRepositoryImpl() }
}
```

#### **[B] `factory`**: It will provide new instance each time it is asked for.
```kotlin
val applicationModule = module {
    factory<LoginRepository> { LoginRepositoryImpl() }
}
```

---
# Step 4 :- Starting Koin

Start Koin in the sub-class of an `Application`.

```kotlin
startKoin {
    androidLogger()
    androidContext(this@KoinApplication)
    modules(applicationModule)
}
```

---
# Step 5 :- Inject Dependency

```kotlin
private val loginRepository: LoginRepository by inject()
```
We can use following to inject dependecy without lazy way.

```kotlin
private val loginRepository: LoginRepository  = get()
```

---
# Named Dependencies

### Provide

```kotlin
single(qualifier = named("API_KEY")) { "1234567890" }

factory(qualifier = named("STATIC_TOKEN")) { "AZAZIFIFGHT" }
```
### Inject
```kotlin
private val apiKey: String by inject(qualifier = named("API_KEY"))

private val staticToken: String = get(qualifier = named("STATIC_TOKEN"))
```

---
# ViewModel Dependencies

### Provide
```kotlin
viewModel { MainViewModel(get()) }
```
### Inject
```kotlin
private val viewModel: MainViewModel by viewModel()
```

---
# General Questions

### [1] What exception would you get when you inject a dependency without providing it?
`org.koin.core.error.NoBeanDefFoundException: No definition found for 'com.sample.koin.data.repository.LoginRepositoryImpl' has been found. Check your module definitions.`
