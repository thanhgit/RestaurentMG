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
│   ├── AppCompatPreferenceActivity.java
│   ├── DrinkActivity.java
│   ├── ExpandDrinkActivity.java
│   ├── ExpandFoodActivity.java
│   ├── FlashActivity.java
│   ├── FoodActivity.java
│   ├── FoodMenuActivity.java
│   ├── ForgetPasswordActivity.java
│   ├── HomeActivity.java
│   ├── LoginActivity.java
│   ├── RegisterActivity.java
│   ├── SearchActivity.java
│   ├── SettingsActivity.java
│   ├── SetupActivity.java
│   ├── TableActivity.java
│   └── TutorialActivity.java
├── adapter
│   ├── ExpandFoodViewPaperAdapter.java
│   ├── FoodMenuImageRecycleViewAdapter.java
│   ├── FoodMenuMenuDrinkRecycleViewAdapter.java
│   ├── FoodMenuMenuFoodRecycleViewAdapter.java
│   ├── FoodMenuSearchRecycleViewAdapter.java
│   ├── FoodMenuViewPaperAdapter.java
│   ├── TableRoomRecycleViewAdapter.java
│   └── TableViewPaperAdapter.java
├── dialog
│   └── FoodMenuImageDialog.java
├── fragment
│   ├── ExpandDrinkAllFragment.java
│   ├── ExpandDrinkFavoriteFragment.java
│   ├── ExpandDrinkRecentFragment.java
│   ├── ExpandFoodAllFragment.java
│   ├── ExpandFoodFavoriteFragment.java
│   ├── ExpandFoodRecentFragment.java
│   ├── ImageFoodMenuFragment.java
│   ├── MenuFoodMenuFragment.java
│   └── TableRoomFragment.java
├── GridSpacingItemDecoration.java
├── MVPWorkFlow
│   ├── Model
│   │   ├── dao
│   │   ├── entity
│   │   │   ├── drink
│   │   │   ├── food
│   │   │   ├── OrderObject.java
│   │   │   ├── room
│   │   │   ├── SearchObject.java
│   │   │   ├── staff
│   │   │   ├── table
│   │   │   └── user
│   │   └── interact
│   │       ├── foodmenu
│   │       ├── login
│   │       ├── order
│   │       ├── payment
│   │       ├── register
│   │       └── search
│   ├── Presenter
│   │   ├── PresenterFoodMenu.java
│   │   ├── PresenterLogin.java
│   │   ├── PresenterPayment.java
│   │   └── PresenterRegister.java
│   └── View
│       ├── IViewFoodMenu.java
│       ├── IViewLogin.java
│       ├── IViewPayment.java
│       └── IViewRegister.java
├── server
│   ├── APIUtils.java
│   ├── DrinkAPI
│   ├── FoodAPI
│   ├── PaymentAPI
│   ├── ServerClient.java
│   ├── TableAPI
│   └── UserAPI
├── ToolbarMenu.java
└── usersessionmg
    ├── AlertDialogManager.java
    ├── IAlertDialogFinishedListener.java
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
