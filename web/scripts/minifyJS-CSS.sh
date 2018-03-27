tsc -p src/main/webapp/app/ng2app/

r.js -o src/main/webapp/app/app.build.js dir=src/main/webapp/app-$1

r.js -o cssIn=src/main/webapp/assets/css/main.css out=src/main/webapp/assets/css/main-built-$1.css

exit 0