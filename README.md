# TestAssignment for XISCHE Digital

Test Submitted by Syed Zain Ali  

The application should include two modules, Module Listing and Module Detail with only two screens (a listing screen and a details screen).
The first attempt is to break the project into 3 modules Data, Domain and Presentation, and later break it further into feature based modules. 

Modular App Architecture talks
* [Modularizing Android Applications - Marvin Ramin](https://www.youtube.com/watch?v=TWLkswxjSr0)
* [Build a modular Android app architecture - Google I/O'19](https://www.youtube.com/watch?v=PZBg5DIzNww&t=1050s)


## Project Characteristics

This project makes use of the following tools and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Modern architecture (Clean Architecture, Model-View-ViewModel)
* Dependency Injection
* Testing (Unit, UI)

* Tech-stack 
  * [Retrofit](https://square.github.io/retrofit/) - networking
  * [Jetpack](https://developer.android.com/jetpack)
  * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
  * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
  * [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - declaratively bind UI components in layouts to data sources.
  * [Room](https://developer.android.com/topic/libraries/architecture/room) - persistence 


* Architecture
    * Clean Architecture (at module level)
    * MVVM (presentation layer)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) 
    * ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)


* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    * Plugins ([SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args))


## Architecture
Clean Architecture is the "core architecture" of this application. The main purpose of this approach is to achieve a separation of concerns which Clean architecture helps with and in
making the code loosely coupled. This approach results in a more testable and flexible code. 


* **Presentation**: Layer with the Android Framework, the MVVM pattern and the DI module. Depends on domain to access the use cases and on DI, to inject dependencies. This is the layer closest
  to what the user sees on the screen.
    - **MVVM**: The Model View ViewModel pattern helps with the separation of concerns, dividing the user interface with the logic behind. It combines very well with Android Architecture Components like LiveData and DataBinding.
* **Domain**: This is the core layer of the application with the business logic. It contains the use cases, in charge of calling the correct repository or data member.The domain layer is independent of any other layers.
* **Data**: Layer with the responsibility of managing the application data and exposes these data sources as repositories to the domain layer. Typical responsibilities of this layer is to retrieve data from the internet and optionally cache this data locally.

### Dependency Injection with Hilt
Dependency injection is closely related to two SOLID concepts: dependency inversion, which states that high level modules should not depend on low level modules,
both should depend on abstractions; and single responsibility principle,
which states that every class or module is responsible for just a single piece of functionality.

