'use strict'
class Enemy extends GameObject {
    constructor(x, y) {
        super(x, y)
        this.objId = 'ENEMY'
    }

    tick(delta) {}
    render(ctx) {}
}
