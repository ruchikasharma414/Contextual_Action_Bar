# Contextual_Action_Bar
To  customize Action Bar, we override Contextual action bar

 @Override
                public void onAnimationEnd(Animation animation) {
                    if (position == 0)
                        listView.setVisibility(View.INVISIBLE);

                    firstLoad = true;
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
