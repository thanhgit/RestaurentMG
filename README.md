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
│   │   │   ├── StaffDao.java
│   │   │   └── UserDao.java
│   │   ├── entity
│   │   │   ├── drink
│   │   │   │   ├── DrinkBuilder.java
│   │   │   │   ├── Drink.java
│   │   │   │   └── IDrink.java
│   │   │   ├── food
│   │   │   │   ├── FoodBuilder.java
│   │   │   │   ├── Food.java
│   │   │   │   └── IFood.java
│   │   │   ├── OrderObject.java
│   │   │   ├── room
│   │   │   │   ├── IRoom.java
│   │   │   │   ├── RoomBuilder.java
│   │   │   │   └── Room.java
│   │   │   ├── SearchObject.java
│   │   │   ├── staff
│   │   │   │   ├── IStaff.java
│   │   │   │   ├── StaffBuilder.java
│   │   │   │   └── Staff.java
│   │   │   ├── table
│   │   │   │   ├── ITable.java
│   │   │   │   ├── TableBuilder.java
│   │   │   │   └── Table.java
│   │   │   └── user
│   │   │       ├── IUser.java
│   │   │       ├── UserBuilder.java
│   │   │       └── User.java
│   │   └── interact
│   │       ├── foodmenu
│   │       │   ├── IFoodMenuFinishedListener.java
│   │       │   ├── IModelFoodMenu.java
│   │       │   └── ModelFoodMenu.java
│   │       ├── login
│   │       │   ├── ILoginFinishedListener.java
│   │       │   ├── IModelLogin.java
│   │       │   └── ModelLogin.java
│   │       ├── order
│   │       │   ├── IModelOrder.java
│   │       │   ├── IOrderFinishedListener.java
│   │       │   └── ModelOrder.java
│   │       ├── payment
│   │       │   ├── IModelPayment.java
│   │       │   ├── IPaymentFinishedListener.java
│   │       │   └── ModelPayment.java
│   │       ├── register
│   │       │   ├── IModelRegister.java
│   │       │   ├── IRegisterFinishListener.java
│   │       │   └── ModelRegister.java
│   │       └── search
│   │           ├── IModelSearch.java
│   │           ├── ISearchFinishedListener.java
│   │           └── ModelSearch.java
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
│   │   ├── DrinkClient.java
│   │   ├── DrinkDataOutput.java
│   │   ├── DrinkFindOutput.java
│   │   ├── DrinkOutput.java
│   │   └── DrinkQueryNameOutput.java
│   ├── FoodAPI
│   │   ├── FoodClient.java
│   │   ├── FoodDataOutput.java
│   │   ├── FoodFindDataOutput.java
│   │   ├── FoodFindOuput.java
│   │   ├── FoodOutput.java
│   │   ├── FoodQueryNameDataOutput.java
│   │   └── FoodyQueryNameOutput.java
│   ├── PaymentAPI
│   │   ├── PaymenDataOutput.java
│   │   ├── PaymenTableOutput.java
│   │   ├── PaymentClient.java
│   │   └── PaymentOutput.java
│   ├── ServerClient.java
│   ├── TableAPI
│   │   ├── TableAddDataOutput.java
│   │   ├── TableAddOutput.java
│   │   ├── TableByIdDataOutput.java
│   │   ├── TableByIdOutput.java
│   │   ├── TableClient.java
│   │   ├── TableDataOutput.java
│   │   └── TableOutput.java
│   └── UserAPI
│       ├── LoginDataOutput.java
│       ├── LoginOutput.java
│       ├── RegisterDataOutput.java
│       ├── RegisterOutput.java
│       └── UserClient.java
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
