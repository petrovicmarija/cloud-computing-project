from . import views
from django.urls import path

urlpatterns = [
    path('ftnservice', views.index, name='home'),
    path('ftnservice/add-student', views.add_student),
    path('ftnservice/add-professor', views.add_professor),
    path('ftnservice/students', views.save_new_student),
    path('ftnservice/professors', views.save_new_professor),
    path('ftnservice/students', views.get_students, name='list-students'),
    path('ftnservice/professors', views.get_professors, name='list-professors'),
]