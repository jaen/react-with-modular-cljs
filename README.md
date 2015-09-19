# Using raw React with (hacked) Clojurescript, reagent & boot.

This implements enough handling of CommonJS modules in Clojurescript
and other two libraries that it lets you use raw npm React with
reagent and boot.

Adding other libraries probably won't work for now (it's not handling things
like `name` and `main` options of `package.json` which will mean that there will
be some requires that just won't get resolved during conversion).

Just run
```
npm install && boot dev
```
and it should get you the usual boot reloadable workflow, enjoy.
