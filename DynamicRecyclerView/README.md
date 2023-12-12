# DynamicRecyclerView

하나의 어댑터로 여러가지 뷰홀더를 나타내는 DynamicRecyclerView 구현

### 방법
1. 여러가지 ViewHolder들을 한 곳의 정의하였습니다.
<img width="864" alt="image" src="https://user-images.githubusercontent.com/59405161/182272101-a5a56be1-11b7-4e7e-881c-8df6b93b6171.png">
2. Enum 클래스를 사용해 ViewType과 학생정보를 나타내었습니다.
<img width="995" alt="image" src="https://user-images.githubusercontent.com/59405161/182272336-19996fd6-6621-4339-be95-5217169c9935.png">
3. 어댑터에서 viewType에 맞게 홀더를 만들고 getItemViewType 메서드를 오버라이드해서 viewType을 반환하게 하였고 Bind 해주었습니다.
<img width="1128" alt="image" src="https://user-images.githubusercontent.com/59405161/182272601-5ca9523c-da32-432d-9ff4-03ea8ca52583.png">
# 결과
<img width="429" alt="image" src="https://user-images.githubusercontent.com/59405161/182271909-281078cb-260c-4c3c-a5c7-108bdb591087.png">
