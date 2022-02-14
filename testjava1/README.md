# testjava1
AN EXAMPLE
More changes made
// make branch
git checkout -b 'newBranch'

// save changes
git add .
git commit -m "name the change"
git push --set-upstream origin newBranch
git checkout newBranch

// merge branches
git merge newBranch

// resolve binary conflicts
git checkout --theirs test.bmp
// or
git checkout --ours test.bmp

//pull data from master branch
git pull upstream