from django.db import models


# Create your models here.

class Student(models.Model):
    id = models.BigIntegerField(primary_key=True)
    name = models.CharField(max_length=50)
    surname = models.CharField(max_length=50)
    index = models.CharField(max_length=20)
    faculty = models.CharField(max_length=100)

    def __str__(self):
        return f'{self.id} {self.name} {self.surname} {self.index} {self.faculty}'


class Professor(models.Model):
    id = models.BigIntegerField(primary_key=True)
    name = models.CharField(max_length=50)
    surname = models.CharField(max_length=50)
    faculty = models.CharField(max_length=100)

    def __str__(self):
        return f'{self.id} {self.name} {self.surname} {self.faculty}'
