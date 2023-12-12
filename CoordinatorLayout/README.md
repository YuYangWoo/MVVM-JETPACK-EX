# CoordinatorLayout
## 👍 Features
- CoordinatorLayout : CoordinatorLayout을 사용하여 Scroll시 FloatingActionButton을 show() / hide()하는 코드와 AppBarLayout을 통해 View간의 상호작용하는 예제를 만들었습니다. 
- AppBarLayout : CoordinatorLayout과 AppBarLayout을 사용하여 Scroll시 Fragment의 상단 부분에 효과를 줬습니다.
- CollapsingToolbarLayout : CollapsingToolbarLayout의 Title 기능과 CollapseMode를 사용하여 효과를 줬습니다.
- Anchor : CoordinatorLayout의 Anchor를 사용하여 FloatingActionButton의 위치를 표현했습니다. 
- Behavior / Event : CoordinatorLayout과 Custom Behavior를 사용하여 Scroll시 FloatingActionButton을 show() / hide() 했습니다.
## 😁 Introduction
### MainFragment
- ViewPager2와 TabLayout을 사용하여 MovieList와 FavoriteMovieList를 표현했습니다.
- AppBarLayout의 layout_scrollFlags 를 사용하여 Scroll을 내리면 TabLayout을 사라지게 하고 Scroll을 올리면 TabLayout을 보이게 했습니다.
<img width="420" alt="image" src="https://user-images.githubusercontent.com/59405161/182281830-63d95d94-a4d0-4074-8abf-ed38e3f18d52.png">
<img width="420" alt="image" src="https://user-images.githubusercontent.com/59405161/182282126-6e6c2202-6d47-4c81-a3c7-72f1e2e32859.png">

### MovieListFragment
- Movie를 RecyclerView의 GridLayoutManager로 나타내었습니다.
- Glide를 사용하여 영화의 포스터를 ImageView에 업데이트했습니다.
<img width="420" alt="image" src="https://user-images.githubusercontent.com/59405161/182281830-63d95d94-a4d0-4074-8abf-ed38e3f18d52.png">

### FavoriteMovieFragment
- MovieData의 isFavorite의 여부에 따라서 필터링되게 했습니다.
<img width="418" alt="image" src="https://user-images.githubusercontent.com/59405161/182282435-a346a738-03c2-4c4e-ba86-fd12df14b216.png">

### MovieInformationFragment
- Navigation을 통해 Movie를 arg로 받습니다.
- CollapsingToolbarLayout을 사용하여 Title을 표현하고 CollapseMode를 pin으로 설정하여 Collapse된 상태에서 Movie의 Title을 보여줍니다.
- FloatingActionButton에 Custom Behavior를 설정하여 Scroll을 내리면 숨기고 Scroll을 올리면 보이게 하였습니다.

![InformationFragment](https://user-images.githubusercontent.com/59405161/182283038-330db463-ee64-49ff-b08b-1d4b286b7127.gif)

