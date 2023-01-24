from . import views
from django.urls import path

urlpatterns = [
    path('pravniservice', views.index, name='home'),
    path('pravniservice/add-student', views.add_student),
    path('pravniservice/add-professor', views.add_professor)
]