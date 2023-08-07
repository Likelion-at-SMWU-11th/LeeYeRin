from django.urls import path

from .views import article_list_view, article_create_view 
from .views import article_delete_view, article_detail_view

app_name='article'

urlpatterns = [
    path('', article_list_view, name = 'article-list'),
    path('new/', article_create_view),
    path('<int:id>/', article_detail_view),
    path('<int:id>/delete', article_delete_view),
]
