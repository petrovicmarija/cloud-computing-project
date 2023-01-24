from django import forms


class AddStudentForm(forms.Form):
    id = forms.IntegerField(label='Id')
    name = forms.CharField(label='Name')
    surname = forms.CharField(label='Surname')
    index = forms.CharField(label='Number of index')
    faculty = forms.CharField(label='Faculty name')


class AddProfessorForm(forms.Form):
    id = forms.IntegerField(label='Id')
    name = forms.CharField(label='Name')
    surname = forms.CharField(label='Surname')
    faculty = forms.CharField(label='Faculty name')