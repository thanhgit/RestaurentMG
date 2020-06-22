# RestaurentMG
```text
This is android apps about food search in restaurant context.
Technical stack:
- Architecture system: client - server with support of retrofit library.
- Architecture software: MVP pattern
```

## Overview of application
![overview of application](callfood.png)

## File structure
```text
restaurentmg/
├── activity
├── adapter
├── dialog
├── fragment
├── MVPWorkFlow
│   ├── Model
│   │   ├── dao
│   │   ├── entity
│   │   └── interact
│   ├── Presenter
│   └── View
├── server
│   ├── APIUtils.java
│   ├── DrinkAPI
│   ├── FoodAPI
│   ├── PaymentAPI
│   ├── ServerClient.java
│   ├── TableAPI
│   └── UserAPI
└── usersessionmg
    └── SessionManager.java
```

## Functionality of directories
| Directory | Description |
| :---: | :---: |
| activity | define activity, each activity file mapping to one screen in apps |
| adapter | define way of display data with RecyclerView.Adapter, FragmentPaperAdapter, ...  |
| dialog|  define dialogs, such as pop-up dialog|
| fragment|  define fragments|
|MVPWorkFlow| define workflow of application  |
|server|  define way get data from external server|
|usersessionmg| define way interact with SharedPreferences  |
## Technical Support or Questions
If you have questions or need help integrating the product please "thanh29695@gmail.com" instead of opening an issue
