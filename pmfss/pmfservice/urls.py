from . import views
from django.urls import path

urlpatterns = [
    path('pmfservice', views.index, name='home'),
    path('pmfservice/add-student', views.add_student),
    path('pmfservice/add-professor', views.add_professor)
]