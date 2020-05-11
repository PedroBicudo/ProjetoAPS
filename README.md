# Projeto APS

<image src="https://user-images.githubusercontent.com/43938917/81577555-f0e6ab00-937f-11ea-86fd-ac26a353fa98.gif" width="300" height="500"/>

### Clonando o projeto
```
git clone https://github.com/PedroBicudo/ProjetoAPS.git
```

### Dicas de uso
- Sempre crie uma branch quando for realizar alguma alteração:
```
# Criando branch
git checkout -b nome/funcionalidade

# Vendo a branch atual
git branch

# Mudando para a master branch
git checkout master

# Mudando de uma branch A para uma branch B
git checkout B

# Sincronizando a branch criado com a master branch
git merge <nome da branch criada>
```
- Sempre faça mudanças pequenas no código:
```
git add x
git commit -m "Adicionado o recurso X."

git add x
git commit -m "Adicionado o recurso Y."

git add x
git commit -m "Adicionado o recurso Z."
```
- Não gostou de um commit já feito? Então retorne pelo hash:
```
# Pegue o hash do commit anterior
git log

# Cole o commit
git reset <hash>

```

### Básico do básico
- [Máquina Virtual](https://source.android.com/devices/tech/dalvik)
- [Compilação](http://www.theappguruz.com/blog/android-compilation-process)

### Terminologia android
- [Context](https://www.youtube.com/watch?v=JzewiQixgRI)
- [Activity](https://www.androidpro.com.br/blog/desenvolvimento-android/activity-intro/)
- [View](https://developer.android.com/reference/android/view/View)
- [Inflater](https://www.youtube.com/watch?v=OruZfYp0GLM)

### Coisas úteis
- [Hardcode](https://stackoverflow.com/questions/28674267/android-app-layout-looks-bad-with-hardcoded-values)
- [Eventos onClick](https://androidacademic.blogspot.com/2016/12/multiple-buttons-onclicklistener-android.html)
- [Design pattern](https://www.tutorialspoint.com/design_pattern/design_pattern_overview.htm)
- [ViewBinding Artigo](https://www.raywenderlich.com/6430697-view-binding-tutorial-for-android-getting-started)
- [ViewBinding Vídeo](https://www.youtube.com/watch?v=jIBW6HFcpv8)
- [Merge github](https://githowto.com/pt-BR/merging_back_to_master)
