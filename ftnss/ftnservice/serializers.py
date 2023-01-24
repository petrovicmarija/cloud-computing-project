from rest_framework import serializers
from .models import Student, Professor


class StudentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Student
        fields = ('id',
                  'name',
                  'surname',
                  'index',
                  'faculty')


class ProfessorSerializer(serializers.ModelSerializer):
    class Meta:
        model = Professor
        fields = ('id',
                  'name',
                  'surname',
                  'faculty')
