# Udacity_Shoe_Store_app_Aug_2022
This project will consist of five screens. You don't have to create a shoe store, you can use any other item as long as you create the following screens. You will be creating:

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe

## Getting Started

Open the starter project in the latest stable version of Android Studio.

Open the starter project in Android Studio

##Steps

1. Open the starter project in Android Studio

2. Add the navigation libraries to the app build.gradle file

3. Add the safe-arg plugin to the main and app build.gradle file

4. Create a new navigation xml file

5. Create a new Login destination.

   * Include email and password labels 

   - Include email and password fields
   - Create buttons for creating a new login and logging in with an existing account
   - Clicking either button should navigate to the Welcome Screen.

6. Create a new Welcome screen destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the instructions screen

7. Create a new Instruction destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the shoe list screen

8. Create a class that extends ViewModel

   *  Use a LiveData field that returns the list of shoes

9. Create a new Shoe List destination that includes:

   * A new layout
   * A ScrollView
   * A LinearLayout for Shoe Items
   * A FloatingActionButton with an action to navigate to the shoe detail screen

10. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

11. Create a new Shoe Detail destination that includes:

    * A new layout
    * A TextView label and EditView for the
      * Shoe Name
      * Company
      * Shoe Size
      * Description
    * A Cancel button with an action to navigate back to the shoe list screen
    * A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model

12. Make sure you can’t go back to onboarding screens

13. In the Shoe List screen:

    * Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    * Observe the shoes variable from the ViewModel
    * Use DataBindingUtil to inflate the shoe_list layout
    * Add a new layout item into the scrollview for each shoe.# KotlinNanoDegree_ShoeStore
  

<p>

</p>

<table>
  <tr>
    <td>
       <img src = "https://user-images.githubusercontent.com/32135935/184718376-79b06262-0bd5-45a8-b4e8-52ea54e4860e.png"/>
    </td>
   <td>
    <img src = "https://user-images.githubusercontent.com/32135935/184718397-ec8b7967-c6cb-429e-9ee6-3edc10034f80.png"/>
   </td>
    <td>
       <img src = "https://user-images.githubusercontent.com/32135935/184718401-49755fee-823a-4f05-b68e-36c082c8791d.png"/>
    </td>
  </tr>
   <tr>
    <td>
       <img src = "https://raw.githubusercontent.com/alfayedoficial/Udacity_Shoe_Store_app_Aug_2022/master/img/Screenshot_4.png"/>
    </td>
    <td>
       <img src = "https://user-images.githubusercontent.com/32135935/184719376-d4fdcdde-2202-4a07-a539-9a65069e8cd4.png"/>
    </td>
     <td>
       <img src = "https://user-images.githubusercontent.com/32135935/184718631-49dd0505-208f-472c-b743-9a6c0556b4d2.png"/>
    </td>
  </tr>
</table>
